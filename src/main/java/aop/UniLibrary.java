package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
        System.out.println("________________________________________");
    }

    public String returnBook() {
        int a = 10 / 0; // Добавляем эту строку, чтобы выбрасывалось исключение
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("________________________________________");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в UniLibrary");
        System.out.println("________________________________________");
    }

    public void addBook(String personName, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("________________________________________");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniLibrary");
        System.out.println("________________________________________");
    }
}
