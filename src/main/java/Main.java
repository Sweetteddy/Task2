import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String filePath = null;
        String fieldTarget = null;
        String wordTarget = null;

        System.out.println("Укажите путь к файлу .json:" );
        filePath = input.nextLine();
        if(filePath.contentEquals("-d")) {
            System.out.println("Используется файл по умолчанию файл");
            filePath = "./src/main/resources/generated.json";
        }

        System.out.println("Поле для сканирования: ");
        fieldTarget = input.nextLine();
        if(fieldTarget.contentEquals("-d")) {
            System.out.println("Поиск по умолчанию по полю: greeting ");
            fieldTarget = "greeting";
        }

        System.out.println("Введите искомое слово: ");
        wordTarget = input.nextLine();
        if(wordTarget.contentEquals("-d")) {
            System.out.println("Поиск по умолчанию: hello ");
            wordTarget = "hello";
        }

        EnumWords ew = new EnumWords();     //создаем экземпляр класса для поиска слова и знаков препинания

        ew.readJsonField(filePath, fieldTarget);
        ew.searchWord(wordTarget);
        ew.searchSimbols();

        System.out.println("Какие строки будем сравнивать? Нумерация идёт с 0");
        int index1 = input.nextInt();
        int index2 = input.nextInt();
        ew.compareStrings(index1, index2);

        System.out.println("-----------------------");
        System.out.print("Выводим параметр myParam");
        String myParam = System.getProperty("myParam");
        System.out.println(myParam);

    }
}
