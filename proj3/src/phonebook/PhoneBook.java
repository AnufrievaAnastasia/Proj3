/*Вам необходимо создать телефонный справочник для записи номеров телефонов phonebook.PhoneBook,
у которого должны быть следующие методы:
* public List<Record> getAllRecords() - метод возвращает список из всех записей справочника.
* public void createRecord(Record record) - метод сохраняет в справочнике новую запись.
Если в справочнике есть запись с таким же номером телефона, выбросить проверяемое исключение PhoneNumberAlreadyExists.
* public void updateRecord(Record record) - метод обновляет запись в справочнике.
Если запись с таким идентификатором не существует, выбросить непроверяемое исключение RecordNotFound.
Если в новой записи не заполнено поле name и/или поле phoneNumber, выбросить проверяемое исключение RecordNotValid.
* public void deleteRecord(long id) - удаляет запись из справочника по идентификатору, если подходящая запись
в справочнике не найдена - выбрасывается непроверяемое исключение RecordNotFound.
Все методы работают с объектом типа Record. У него должны быть поля id (идентификатор типа long),
phoneNumber (номер телефона типа String) и поле name (имя типа String).
Все исключения создать самостоятельно. Проверяемые исключения отловить в методе main и информативно обработать.
*/
package phonebook;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneBook {

    private final List<Record> getAllRecords = new ArrayList<>();

    public List<Record> getAllRecords(){
        return getAllRecords;
    }

    public void createRecord(Record record){
        try {
            for (int i = 0; i < getAllRecords.size(); i++) {
                if (record.getPhoneNumber().equals(getAllRecords.get(i).getPhoneNumber())) {
                    throw new PhoneNumberAlreadyExists("Уже есть");
                }
            }
        }catch(PhoneNumberAlreadyExists e) {
            System.out.println("Exception name: " + e.toString());
            return;
        }

            getAllRecords.add(record);
            System.out.println("Контакт добавлен.");

        }

    public void updateRecord(Record record) {

        try {
            if (Objects.equals(record.getName(), " ") || Objects.equals(record.getPhoneNumber(), " ")) {
                throw new RecordNotValid();


            }

            if (record.getName() == null || Objects.equals(record.getPhoneNumber(), null)) {
                throw new RecordNotValid();


            }

            for (int i = 0; i < getAllRecords.size(); i++) {

                if (record.getId() == (getAllRecords.get(i).getId())) {
                    getAllRecords.remove(getAllRecords.get(i));
                    getAllRecords.add(record);
                    System.out.println("Обновлено");
                    return;
                }
                if ((i + 1) == (getAllRecords.size())) {
                    if (record.getId() != (getAllRecords.get(i).getId())) {
                        throw new RecordNotFound("Несуществующий номер");
                    }
                }
            }

        } catch (RecordNotValid exception) {
            System.out.println("Exception name: " + exception.toString());
        }
    }


    public void deleteRecord(long id){
            for (int i = 0; i < getAllRecords.size(); i++) {
                if (id == (getAllRecords.get(i).getId())) {
                    getAllRecords.remove(getAllRecords.get(i));
                    System.out.println("Контакт удален.");
                    return;
                }

            }
            throw new RecordNotFound("Не существующий номер");
}
}

