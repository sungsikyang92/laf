<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Laf Lostwrite</title>
            <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
            <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
            <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
            <link rel="stylesheet"
                href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
            <link rel="stylesheet" href="/resources/css/lostUpdate.css" type="text/css">

            <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri"></script>
            <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri&submodules=geocoder"></script>


            <script type="text/javascript">
                function getClickId(clickId) {
                    let picNo = clickId;
                    $.ajax({
                        type: "get",
                        data: "picNo=" + picNo,
                        dataType: "json",
                        url: "/picture/delete/" + picNo,
                        success: function (pictureList) {
                            let tags = '';
                            for (let i = 0; i < pictureList.length; i++) {
                                tags += "<article class='location-listing'>"
                                tags += "<div class='location-image'>";
                                tags += "<img width='300' height='169' src='" + pictureList[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                                tags += "</div>";
                                tags += "</article>";
                                tags += "<div>";
                                tags += "<input type='button' value='삭제' id='" + pictureList[i].picNo + "' class='imgDeleteBtn' onclick='getClickId(this.id)'>";
                                tags += "</div>";
                                //엘리먼트만 지운다.
                            }
                            $("#imageList").html();
                            $("#imageList").html(tags);
                        }
                    })
                }
            </script>

        </head>

        <body class="body_container">
            <jsp:include page="../UI/topMenu.jsp" flush="true" />


            <!-- 컨텐츠 삽입부분-->
            <div class="contents_container">
                <form action="/update/${lboard.LBoardNo}" method="post" enctype="multipart/form-data">



                    <div id="image_container">
                        <div id="imageList">
                            <c:choose>
                                <c:when test="${empty pDetail}">
                                    <td>등록된 사진이 없습니다</td>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${pDetail}" var="pd">
                                        <article class="location-listing">
                                            <div class="location-image">
                                                <img width="300" height="169" src="${pd.storedFilePath}"
                                                    alt="사진을 불러올수가 엄써" class="img" />
                                            </div>
                                            <input type="button" value="삭제" id="${pd.picNo}" class="imgDeleteBtn"
                                                onclick="getClickId(this.id)">
                                        </article>

                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                    <input type="file" id="pictureUpload" name="pictureUpload" accept="image/*"
                        onchange="setThumbnail(event);" multiple />
                    <button type="button" onclick="resetFile()">올린파일 초기화</button>
                    <br>
                    <c:if test="${lboard.LCategory eq '분실'}">
                        <h2>분실<input type="radio" name="lCategory" id="" value="분실" checked="checked" /></h2>
                    </c:if>
                    <c:if test="${lboard.LCategory eq '습득'}">
                        <h2>습득<input type="radio" name="lCategory" id="" value="습득" checked="checked" /></h2>
                    </c:if>
                    <br>
                    <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
                        <input type="text" name="lTitle" placeholder="${lboard.LTitle}" />
                    </h1>
                    <br>
                    <h2>글 내용 : <br>
                        <textarea cols="150" rows="15" name="lContent" placeholder="${lboard.LContent}"></textarea>
                    </h2>
                    <br>
                    <h3 style="border-top:solid 2px rgb(169, 169, 169);">
                        문제 :<input type="text" name="lQuestion" placeholder="${lboard.LQuestion}" />
                    </h3>
                    <br>
                    <h3>
                        정답 :<input type="text" name="lAnswers" placeholder="${lboard.LAnswers}" />
                    </h3>
                    <br>
                    <h3>
                        오답 :<input type="text" name="lAnswers1" placeholder="${lboard.LAnswers1}" />
                    </h3>
                    <br>
                    <h3>
                        오답 :<input type="text" name="lAnswers2" placeholder="${lboard.LAnswers2}" />
                    </h3>
                    <br>
                    <h3>
                        오답 :<input type="text" name="lAnswers3" placeholder="${lboard.LAnswers3}" />
                    </h3>
                    <br>
                    <h3>
                        오답 :<input type="text" name="lAnswers4" placeholder="${lboard.LAnswers4}" />
                    </h3>
                    <br>
                    <h2>지도</h2>
                    <div id="map" style="width:60%;height:400px;">
                        <div class="search">
                            <input id="address" type="text" placeholder="검색할 주소" value="" />
                            <input id="addsubmit" type="button" value="주소 검색" />
                        </div>
                    </div>
                    <br>
                    <div id="location" class="location"></div>
                    <h4>지도로 위치를 설정하시면 해당위치로 검색시 노출됩니다.</h4>
                    <br>
                    <h2>HashTag</h2>
                    <input id="hashtag" name="hashtag" type="text" size="50" placeholder="검색 노출 태그 입력 ,로 입력해주세요.">
                    <br>
                    <button id="submit" type="submit">ㅋㅋ임시제출임</button>
                </form>
            </div>

            <jsp:include page="../UI/sideMenu.jsp" flush="true" />

            <script src='/resources/js/readImage.js'></script>
            <script src='/resources/js/main_sidebar.js'></script>
            <script src='/resources/js/naverMapApiTest3.js'></script>

        </body>

        </html>