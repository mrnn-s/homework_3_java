/**В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. 
Значения null не включаются в запрос.
*/

public class z1 {
    public static void main(String[] args) {
        String input = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"; //  /'' или через filereader 
        input = input.substring(1, input.length() - 1);
        System.out.println(input);

        StringBuilder builder = new StringBuilder(); //билдер
        builder.append("SELECT * FROM students WHERE ");

        String[] parts = input.split (", "); // разделяем по запятой с пробелом 
        boolean fact = true;
        for (String part : parts) {
            String[] keyValue = part.split (":"); // массив
            String key = keyValue[0];
            key = key.substring (1, key.length() - 1); // обрезаем кавычки
            String value = keyValue[1];

            if (value.equals ("\"null\"")) { 
                continue;
            }
            if (fact){
                builder.append(" AND ");
            }
            builder.append (String.format ("%s = %s", key, value));
            fact = false;
        }
        builder.append(";");
        System.out.println(builder.toString());
    }
}
    
