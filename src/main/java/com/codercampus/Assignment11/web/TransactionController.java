package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String redirectToTransactions () {
        return "redirect:/transactions";
    }

    @GetMapping("/error")
    public String error (ModelMap model) {
        return "error";
    }

    @GetMapping ("/transactions")
    public String transactions(ModelMap model) {
        List<Transaction> transactions = transactionService.findAll();
        model.put("transactions", transactions);

        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransaction (@PathVariable Integer transactionId, ModelMap model) {
        Transaction transaction = transactionService.findById(transactionId);
        model.put("transaction", transaction);
        return "transaction";
    }
}
