package DesignPatterns.task;

import DesignPatterns.task.helpers.Helper;
import DesignPatterns.task.helpers.HelperFactory;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Helper helper = HelperFactory.get().getPostgreSQLHelper();

        helper.create(new Entity(0, new Object()));
        helper.get(1);
        helper.get(0);
        helper.generateHTML("abooba");
        helper.generatePDF("ssss");

        System.out.println(helper.getAll().stream().map(Entity::getId).collect(Collectors.toList()));
        helper.dropDB();
        System.out.println(helper.getAll());

    }
}
