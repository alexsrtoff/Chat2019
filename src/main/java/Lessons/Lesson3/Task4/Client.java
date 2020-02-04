package Lessons.Lesson3.Task4;

import Lessons.Lesson3.Task4.Object.Book;
import Lessons.Lesson3.Task4.Object.Student;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Client {


    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int PORT = 8081;
    public Client() {

        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Student student = new Student(1, "Bob");
            Book book = new Book("Jungle Book");
            student.book = book;
            student.info();

            byte[] stud = null;
            try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
                ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
                objOut.writeObject(student);
                stud = barrOut.toByteArray();
//                System.out.println("Stud до сериализации: " + student);
//                System.out.println("Вот так он выглядит в байтовом представлении: " + Arrays.toString(stud));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Byte b: stud){
                out.writeInt(b);
            }
            out.writeInt(300);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
