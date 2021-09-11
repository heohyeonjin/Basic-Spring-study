//검색 결과 주고받기
//NaverShopSerach.java를 통해 사용자가 검색한 정보를 클라이언트에 돌려주기 위한 도구
package com.sparta.week04.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class ItemDto {
    //title , link, image, lprice
    private String title;
    private String link;
    private String image;
    private int lprice;

    //Setter 대신에 생성자를 통해서 정보 주입
    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.image = itemJson.getString("image");
        this.link = itemJson.getString("link");
        this.lprice = itemJson.getInt("lprice");
    }
}
