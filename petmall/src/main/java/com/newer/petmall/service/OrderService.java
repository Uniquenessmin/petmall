package com.newer.petmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newer.petmall.domain.Item;
import com.newer.petmall.domain.LineItem;
import com.newer.petmall.domain.Order;
import com.newer.petmall.mapper.ItemMapper;
import com.newer.petmall.mapper.LineItemMapper;
import com.newer.petmall.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private LineItemMapper lineItemMapper;

	@Transactional
	public void insertOrder(Order order) {
		
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			String itemId = lineItem.getItemId();
			Integer increment = new Integer(lineItem.getQuantity());
			Map<String, Object> param = new HashMap<String, Object>(2);
			param.put("itemId", itemId);
			param.put("increment", increment);
			itemMapper.updateQuantity(param);
		}

		orderMapper.insertOrder(order);
		
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			lineItem.setOrderId(order.getOrderId());
			lineItemMapper.insertLineItem(lineItem);
		}
	}

	@Transactional
	public Order getOrder(int orderId) {
		Order order = orderMapper.getOrder(orderId);
		order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));

		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			Item item = itemMapper.getItem(lineItem.getItemId());
			item.setQuantity(itemMapper.getQuantity(lineItem.getItemId()));
			lineItem.setItem(item);
		}

		return order;
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderMapper.getOrdersByUsername(username);
	}

}
