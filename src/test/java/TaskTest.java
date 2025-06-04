import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void singleMatchSearchTrue() {
        Epic epic = new Epic(22, new String[]{"Хлеб", "Молоко", "Сыр"});

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void singleMatchSearchFalse() {
        Epic epic = new Epic(22, new String[]{"Хлеб", "Молоко", "Сыр"});

        boolean actual = epic.matches("Сметана");

        Assertions.assertFalse(actual);
    }

    @Test
    public void searchOfProgectMatchTrue() {
        Meeting meet = new Meeting(33, "Обсуждение проекта", "Новый функционал", "Воскресенье, 13-00");

        boolean actual = meet.matches("функционал");

        Assertions.assertTrue(actual);
    }

    @Test
    public void searchOfTopicMatchTrue() {
        Meeting meet = new Meeting(33, "Обсуждение проекта", "Новый функционал", "Воскресенье, 13-00");

        boolean actual = meet.matches("проекта");

        Assertions.assertTrue(actual);
    }

    @Test
    public void searchMeetingFalse() {
        Meeting meet = new Meeting(33, "Обсуждение проекта", "Новый функционал", "Воскресенье, 13-00");

        boolean actual = meet.matches("Отмена функций");

        Assertions.assertFalse(actual);
    }

    @Test
    public void searchSimpleTaskOneMatchTrue(){
        SimpleTask simple = new SimpleTask(32, "Позвонить домой");

        boolean actual = simple.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void searchSimpleTaskOneMatchFalse(){
        SimpleTask simple = new SimpleTask(32, "Позвонить домой");

        boolean actual = simple.matches("Написать");

        Assertions.assertFalse(actual);
    }

}