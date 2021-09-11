package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//controller,entity,service는 자동으로 component가 등록되어 있음
@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "Bm4OorhqMIHpR3RLANr2");
        headers.add("X-Naver-Client-Secret", "EdRmesCXG2");
        String body = ""; // body를 받아서 응답을 받으면 request에 body를 넣어줌

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value(); //200
        String response = responseEntity.getBody(); //우리가 보는 화면이 문자열 하나로 response에 들어감
        System.out.println("Response status: " + status);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result); //문자열 정보를 JsonObject로 바꾸기  --> {}
        JSONArray items = rjson.getJSONArray("items"); // JsonObject에서 items 배열 꺼내기  -> []
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("iphone");
//        JSONObject rjson = new JSONObject(result);
//        JSONArray items = rjson.getJSONArray("items");
//        for (int i = 0; i < items.length(); i++) {
//            JSONObject itemJson = items.getJSONObject(i);
//            String title = itemJson.getString("title");
//            String image = itemJson.getString("image");
//        }
    }
}