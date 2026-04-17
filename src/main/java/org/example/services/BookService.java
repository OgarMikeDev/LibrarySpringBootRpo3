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

    public void deleteBook(Map<String, Integer> mapRegistration_number) {
        Integer registrationNumberBook = -1;
        for (Map.Entry<String, Integer> entryBook : mapRegistration_number.entrySet()) {
            System.out.println("Что пришло: " + entryBook.getValue());
            registrationNumberBook = Integer.parseInt(String.valueOf(entryBook.getValue()));
            System.out.println("Принял значение: " + registrationNumberBook);
        }

        for (Integer currentRegistrationNumber : listRegistrationNumbersBooks) {
            System.out.println("Текущий номер куки из списка: " + currentRegistrationNumber);
            if (currentRegistrationNumber == registrationNumberBook) {
                listRegistrationNumbersBooks.remove(registrationNumberBook);
                System.out.println("Удалился " + registrationNumberBook);
            }
        }
    }
}
