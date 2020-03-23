package com.mariiapasichna;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1_2 {

    /*
    1) Создать проект Maven. В корень проекта положить текстовый файл с таким содержимым:
{
  "name": "java",
  "persons": [
    {
      "name": "Alex",
      "age": 22
    },
    {
      "name": "Ben",
      "age": 33
    }
  ]
}
Распарсить этот JSON и вывести обьекты через println().

2*) Используя библиотеку Jackson сериализовать полученные обьекты в формате XML и записать в другой файл.
*/

    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Group {
        private String name;
        private List<Person> persons;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "name='" + name + '\'' +
                    ", persons=" + persons +
                    '}';
        }
    }

    public static void main(String[] args) {
        Group group = parseFromJson("Text.txt");
        System.out.println(group);
        serializeToXmlFile("Test.xml", group);
    }

    private static Group parseFromJson(String fileName) {
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            String jsonString = streamFromFiles.collect(Collectors.joining());
            Gson gson = new Gson();
            return gson.fromJson(jsonString, Group.class);
        } catch (IOException e) {
            System.out.println("File " + fileName + " not found");
        }
        return null;
    }

    private static void serializeToXmlFile(String fileName, Group group) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), group);
        } catch (IOException e) {
            System.out.println("File " + fileName + " not found");
        }
    }
}