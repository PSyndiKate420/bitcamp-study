package com.eomcs.design_pattern.iterator.after1;

public class QueueIterator<E> implements Iterator<E> {

  Queue<E> list;

  public QueueIterator(Queue<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return !list.empty();
  }

  @Override
  public E next() {
    E obj = list.poll();
    return obj;
  }

}
