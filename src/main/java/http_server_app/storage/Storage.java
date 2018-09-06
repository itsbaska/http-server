package http_server_app.storage;

import java.util.HashMap;

public class Storage {
  public HashMap<Integer, Data> storage = new HashMap<Integer, Data>();
  private int count;

  public Storage() {
    this.count = 0;
  }

  public Data find(int id) {
    return storage.get(id);
  }

  public void add(Data data) {
    storage.put(count += 1, data);
  }

  public void update(int id, Data newData) {
    Data data = storage.get(id);
    data.body = newData.body;
  }

  public void delete(int id) {
    storage.remove(id);
  }
}
