package dao;

import java.util.List;

public interface GenericDao<T, E> {

	public List<T> list();

	public T find(Long id);

	public void insert(T o);

	public void update(T o);

	public void delete(T o);

}
