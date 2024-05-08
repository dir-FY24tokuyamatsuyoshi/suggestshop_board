<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="shopname">お店の名前</label><br />
<input type = "text" name = "shopname" id = "shopname" value = "${suggestshop.shopname}" />
<br /><br />


<label for = "star">５段階でお店を評価してください</label>
<br />
<input type="number" id="star" name="star" min="0" max="5" />
<br /><br />

<label for = "category">カテゴリー</label>
<br />
<label><input type = "checkbox" name = "category" value = "居酒屋">居酒屋</label>
<label><input type = "checkbox" name = "category" value = "イタリアン">イタリアン</label>
<label><input type = "checkbox" name = "category" value = "フレンチ">フレンチ</label>
<label><input type = "checkbox" name = "category" value = "中華料理">中華料理</label>
<label><input type = "checkbox" name = "category" value = "韓国料理">韓国料理</label>
<label><input type = "checkbox" name = "category" value = "焼肉">焼肉</label>
<label><input type = "checkbox" name = "category" value = "ラーメン">ラーメン</label>

<br /><br />

<label for="comment">一言コメント</label><br />
<input type = "text" name = "comment" id = "comment" value = "${suggestshop.comment}" />
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>
 