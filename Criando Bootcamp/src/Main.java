import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();

        curso1.setTitulo("Curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();

        curso2.setTitulo("Curso Js");
        curso2.setDescricao("descrição curso Js");
        curso2.setCargaHoraria(4);


        Mentoria mentoria = new Mentoria();

        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("descrição mentoria Java");
        mentoria.setData(LocalDate.now());

       /* System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Nikolas");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + dev1.getNome() + dev1.getConteudosInscritos());
        dev1.progredir();
        System.out.println("Conteúdos Inscritos " + dev1.getNome() + dev1.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos " + dev1.getNome() + dev1.getConteudosConcluidos());
        System.out.println("XP: " + dev1.calcularTotalXp());

        System.out.println("\n");

        Dev dev2 = new Dev();
        dev2.inscreverBootcamp(bootcamp);
        dev2.setNome("Caio");
        System.out.println("Conteúdos Inscritos " + dev2.getNome() + dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("Conteúdos Inscritos " + dev2.getNome() + dev2.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos " + dev2.getNome() + dev2.getConteudosConcluidos());
        System.out.println("XP: " + dev2.calcularTotalXp());


    }
}
