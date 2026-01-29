package org.example;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final FamousSayings famousSayings = new FamousSayings();
    String command;
    int id;

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String input = scanner.nextLine();
            if (input.contains("?id=")) {
                String[] commands = input.split("\\?id=");
                command = commands[0];
                id = Integer.parseInt(commands[1]);
            } else command = input;
            switch (command) {
                case "종료" -> System.exit(0);
                case "등록" -> createFamousSaying();
                case "목록" -> printFamousSayings();
                case "삭제" -> deleteFamousSaying(id);
                case "수정" -> updateFamousSaying(id);
            }

        }
    }

    private void updateFamousSaying(int id) {
        Optional<FamousSaying> famousSaying = famousSayings.findById(id);
        if (famousSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + famousSaying.get().getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.println("작가(기존) : " + famousSaying.get().getAuthor());
        System.out.print("명언 : ");
        String author = scanner.nextLine();
        famousSayings.updateFamousSaying(famousSaying.get(), content, author);
    }

    private void deleteFamousSaying(int id) {
        Optional<FamousSaying> famousSaying = famousSayings.findById(id);
        if (famousSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        famousSayings.deleteFamousSaying(famousSaying.get());
        System.out.println(id + "번 명언이 삭제되었습니다.");

    }

    private void printFamousSayings() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<FamousSaying> famousSayingList = famousSayings.findAll();
        for (int i = famousSayingList.size() - 1; i >= 0; i--) {
            System.out.println(famousSayingList.get(i).getId() + " / " + famousSayingList.get(i).getAuthor() + " / " + famousSayingList.get(i).getContent());
        }
    }

    private void createFamousSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        int id = famousSayings.create(content, author);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }
}
