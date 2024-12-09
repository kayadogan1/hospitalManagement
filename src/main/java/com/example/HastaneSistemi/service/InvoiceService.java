package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Invoice;
import com.example.HastaneSistemi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Tüm faturaları getir
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // ID'ye göre fatura getir
    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

    // Yeni fatura ekle
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Fatura güncelle
    public Invoice updateInvoice(Integer id, Invoice updatedInvoice) {
        Invoice existingInvoice = getInvoiceById(id);
        existingInvoice.setTitle(updatedInvoice.getTitle());
        existingInvoice.setDescription(updatedInvoice.getDescription());
        existingInvoice.setAmount(updatedInvoice.getAmount());
        existingInvoice.setPatient(updatedInvoice.getPatient());
        return invoiceRepository.save(existingInvoice);
    }

    // Fatura sil
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
