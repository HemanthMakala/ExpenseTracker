package in.mhp.expensetracker.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mhp.expensetracker.model.Expense;
import in.mhp.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseCsvExportService implements ExpenseCsvExport{
	
	private static final Logger LOG = LoggerFactory.getLogger(ExpenseCsvExportService.class);

	@Autowired
    ExpenseRepository expenseRepository;

    public void writeExpenseToCsv(Writer writer,List<Expense> expenses) {

        System.out.println(expenses);
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Expense expense : expenses) {
                csvPrinter.printRecord(expense.getId(), expense.getExpensename(), expense.getAmount(), expense.getCreatedAt(), expense.getNote());
            }
        } catch (IOException e) {
            LOG.error("Error While writing CSV ", e);
        }
    }

}
