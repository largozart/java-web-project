package com.largo.spring.controller;

import com.largo.spring.domain.Orders;
import com.largo.spring.service.OrderService;
import com.largo.spring.service.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    OrderService orderService = new OrderServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Orders> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        return "order";
    }

    @RequestMapping(value = "/add-new-order", method=RequestMethod.GET)
    public String addNewOrderPage() {
        return "addNewOrder";
    }

    @RequestMapping(value="/add-new-order", method=RequestMethod.POST)
    public String addNewOrder(@RequestParam(value="title") String title, @RequestParam(value="price") Double price) {
        Orders order = new Orders();
        order.setTitle(title);
        order.setPrice(price);
        orderService.save(order);
        return "redirect:/";
    }

    @RequestMapping(value="delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
        Orders order = orderService.getById(id);
        orderService.delete(order);
        return "redirect:/";
    }
}
