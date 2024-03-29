package com.eomcs.design_pattern.iterator.after1;

public class ArrayListIterator<E> implements Iterator<E> {

  ArrayList<E> list;
  int index = 0;

  public ArrayListIterator(ArrayList<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public E next() {
    E obj = list.get(index++);
    return obj;
  }

}
