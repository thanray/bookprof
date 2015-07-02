package org.bookprof.repository;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

import org.bookprof.IntegrationTestCase;
import org.bookprof.model.store.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StoreRepositoryIntegrationTest extends IntegrationTestCase {

  @Autowired
  private StoreRepository storeRepository;

  @Test
  public void testCreate() {
    Store store = new Store();

    store.setName("My new store");
    store.setDesc("new store");
    store.setEmail("store@email.no");
    store.setStorePhone("12345678");

    storeRepository.save(store);

    Iterable<Store> all = storeRepository.findAll();

    Store storeManged = all.iterator().next();

    assertNotNull(store);
    assertEquals("name", "My new store", storeManged.getName());
    assertEquals("email", "store@email.no", storeManged.getEmail());
    assertEquals("email", "new store", storeManged.getDesc());
    assertEquals("phoneNr", "12345678", storeManged.getStorePhone());
  }

}