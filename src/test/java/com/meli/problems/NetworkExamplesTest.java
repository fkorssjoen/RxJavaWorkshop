package com.meli.problems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.clients.ItemClient;
import com.meli.clients.LocationsClient;
import com.meli.clients.NavigationClient;
import com.meli.dto.ItemResponse;
import com.meli.dto.NavigationResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class NetworkExamplesTest {

  private static final String ITEM_FIRST_JSON = "./src/test/resources/mocks/clients/item_first.json";
  private static final String ITEM_SECOND_JSON = "./src/test/resources/mocks/clients/item_second.json";
  private static final String NAVIGATION_JSON = "./src/test/resources/mocks/clients/navigation_user.json";
  private static final String FIRST_TEST_ITEM = "MLC514366774";
  private static final String SECOND_TEST_ITEM = "MLC514222201";

  private static final int TEST_USER_ID = 406763783;

  private ObjectMapper objectMapper;

  private NetworkExamples networkExamples;

  @Mock
  private ItemClient itemClient;

  @Mock
  private NavigationClient navigationClient;

  @Mock
  private LocationsClient locationsClient;

  @Before
  public void setup() {
    networkExamples = new NetworkExamples(itemClient, navigationClient, locationsClient);
    objectMapper = new ObjectMapper();
  }

  @Test
  public void testItemsList() throws Exception {
    List<String> itemIds = Arrays.asList(FIRST_TEST_ITEM, SECOND_TEST_ITEM);

    ItemResponse firstItemResponse = objectMapper.readValue(getFile(ITEM_FIRST_JSON), ItemResponse.class);
    ItemResponse secondItemResponse = objectMapper.readValue(getFile(ITEM_SECOND_JSON), ItemResponse.class);


    Mockito.when(itemClient.getItem(Mockito.eq(FIRST_TEST_ITEM))).thenReturn(Observable.just(firstItemResponse));

    Mockito.when(itemClient.getItem(Mockito.eq(SECOND_TEST_ITEM))).thenReturn(Observable.just(secondItemResponse));

    Observable<List<String>> obsItemsTitle = networkExamples.getItemsTitle(itemIds);

    TestSubscriber<List<String>> testSubscriber = new TestSubscriber<>();

    obsItemsTitle.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    List<String> expectedList = Arrays.asList("Don Carlos El Bosque", "Hernando De Magallanes, Las Condes");

    testSubscriber.assertValue(expectedList);
  }


  @Test
  public void TestNavigationUser() throws Exception {
    final NavigationResponse[] navigationResponseArray = objectMapper.readValue(getFile(NAVIGATION_JSON), NavigationResponse[].class);

    Mockito.when(navigationClient.getNavigationByUser(Mockito.any())).thenReturn(Observable.just(Arrays.asList(navigationResponseArray)));

    ItemResponse firstItemResponse = objectMapper.readValue(getFile(ITEM_FIRST_JSON), ItemResponse.class);
    ItemResponse secondItemResponse = objectMapper.readValue(getFile(ITEM_SECOND_JSON), ItemResponse.class);


    Mockito.when(itemClient.getItem(Mockito.eq(FIRST_TEST_ITEM))).thenReturn(Observable.just(firstItemResponse));

    Mockito.when(itemClient.getItem(Mockito.eq(SECOND_TEST_ITEM))).thenReturn(Observable.just(secondItemResponse));

    Observable<List<String>> obsItemsTitle = networkExamples.getNavigationItems(TEST_USER_ID);

    TestSubscriber<List<String>> testSubscriber = new TestSubscriber<>();

    obsItemsTitle.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    List<String> expectedList = Arrays.asList("Don Carlos El Bosque", "Hernando De Magallanes, Las Condes");

    testSubscriber.assertValue(expectedList);
  }


  public File getFile(String filePath) {
    return new File(filePath);
  }

}
