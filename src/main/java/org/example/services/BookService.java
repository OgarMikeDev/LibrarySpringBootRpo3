package org.example.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    public List<Integer> listRegistrationNumbersBooks = new ArrayList<>();

    public String returnListRegistrationNumbersBooks() {
        return listRegistrationNumbersBooks.toString();
    }

    public void save(Map<String, Integer> map) {
        int registrationNumberBook = -1;
        for (Map.Entry<String, Integer> entryBook : map.entrySet()) {
            registrationNumberBook = entryBook.getValue();
        }
        listRegistrationNumbersBooks.add(registrationNumberBook);
    }
}
