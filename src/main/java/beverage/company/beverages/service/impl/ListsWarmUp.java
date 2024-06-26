package beverage.company.beverages.service.impl;


import beverage.company.beverages.dto.RequestProductDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ListsWarmUp implements ApplicationRunner {

  private void managementList() {
    List<RequestProductDto> lists = new ArrayList<>(Arrays.asList(getProductMock(1), getProductMock(2)));
    lists.add(getProductMock(1));

    //findedSet();
    //lists.forEach(System.out::println);

    //System.out.println(" tipo SET");


    //Set<RequestProductDto> setForSearching= new TreeSet<>(listInitial);

  }
 private void findedSet(){

   Set<RequestProductDto> linkedHashSets = new LinkedHashSet<>();
   List<RequestProductDto> list = new ArrayList<>();
   for (int i = 0; i < 1000000; i++) {
     list.add(getProductMock(i));
     list.add(getProductMock(i));
   }

   System.out.println("::::SET::::::::");
   System.out.println("tamaño de list: "+list.size());
   final Long startArrayList = System.currentTimeMillis();
   Set<RequestProductDto> hashets = new HashSet<>(list);
   final Long endArrayList = System.currentTimeMillis();
   System.out.println("tamaño de set: "+hashets.size());
   System.out.println("time Spend in get list whithout duplicates WHIT SET: " + (endArrayList - startArrayList));

   System.out.println("::::STREAM::::");
   final Long startArrayList2 = System.currentTimeMillis();
   List<RequestProductDto> listWhitouy = list.stream().distinct().collect(Collectors.toList());
   final Long endArrayList2 = System.currentTimeMillis();
   System.out.println("tamaño de list: "+listWhitouy.size());
   System.out.println("time Spend in get list whithout duplicates WHIT Stream: " + (endArrayList2 - startArrayList2));


 }


  private void findedList() {

    List<RequestProductDto> listInitial = new ArrayList<>();
    List<RequestProductDto> linkedList = new LinkedList<>();

    for (int i = 0; i < 10000000; i++) {
      listInitial.add(getProductMock(i));
      linkedList.add(getProductMock(i));
    }

    System.out.println("Searchings in Link");

    final Long startArrayList = System.currentTimeMillis();
    Optional<RequestProductDto> producFind =
        listInitial.stream().filter(a -> a.getName().equals("10000000name")).findFirst();
    final Long endArrayList = System.currentTimeMillis();
    System.out.println("time Spend searching in ArrayList " + (endArrayList - startArrayList));



    final Long startLinkedList = System.currentTimeMillis();
    Optional<RequestProductDto> productFindLinked = linkedList
        .stream()
        .filter(a -> a.getName().equals("10000000name")).findFirst();
    final Long endLinkedList = System.currentTimeMillis();
    System.out.println("time Spend searching in LinkedList " + (endLinkedList - startLinkedList));


    LinkedList<RequestProductDto> linkedListes = new LinkedList<>();

    Queue<RequestProductDto> linkedLiss = new LinkedList<>();

    linkedListes.ad


    linkedListes.addFirst(RequestProductDto.builder()
    .name("any name")
    .unitCost(Double.valueOf(80000)).Status(Boolean.TRUE).build());
    System.out.println("THIS IS IN ESPECIFIC");

    final Long startArrayListForInsert = System.currentTimeMillis();
    listInitial.add(500,RequestProductDto.builder()
        .name("any name")
        .unitCost(Double.valueOf(80000)).Status(Boolean.TRUE).build());
    System.out.println("time Spend Insert in ArrayList " + (System.currentTimeMillis() - startArrayListForInsert));


    final Long startLinkedListForInsert = System.currentTimeMillis();

    linkedList.add(500,RequestProductDto.builder()
        .name("any name")
        .unitCost(Double.valueOf(80000)).Status(Boolean.TRUE).build());
    System.out.println("time Spend Insert in LinkedList " + (System.currentTimeMillis() - startLinkedListForInsert));





  }


  private RequestProductDto getProductMock(Integer name) {
    return RequestProductDto.builder()
        .name(name.intValue() + "name")
        .unitCost(Double.valueOf(name)).Status(Boolean.TRUE).build();

  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Aplicación iniciada y este método se está ejecutando.");
    managementList();

  }
}
