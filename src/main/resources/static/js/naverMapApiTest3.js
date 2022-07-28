var map = new naver.maps.Map("map", {
    mapTypeControl: true
});

var infoWindow = new naver.maps.InfoWindow({
    anchorSkew: true
});

var addressStorge;
var options = {
    enableHighAccuracy: true,
    timeout: Infinity,
    maximumAge: Infinity
};


if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation, options);
} else {
    var center = map.getCenter();
    alert("브라우저가 지원을 안함");
}


function onSuccessGeolocation(position) {

    var location = new naver.maps.LatLng(position.coords.latitude,
        position.coords.longitude);

    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
    map.setZoom(18); // 지도의 줌 레벨을 변경합니다.

    searchCoordinateToAddress(location);

    console.log(`More or less ${position.coords.accuracy} meters.`);

}

function onErrorGeolocation() {
    var center = map.getCenter();
    alert("에러떳음");
}

map.setCursor('pointer');


// 위경도로 서치
function searchCoordinateToAddress(latlng) {
    console.log("la", latlng);

    infoWindow.close();

    naver.maps.Service.reverseGeocode({
        coords: latlng,
        orders: [
            naver.maps.Service.OrderType.ADDR,
            naver.maps.Service.OrderType.ROAD_ADDR
        ].join(',')
    }, function (status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            if (!latlng) {
                return alert('ReverseGeocode Error, Please check latlng');
            }
            if (latlng.toString) {
                return alert('ReverseGeocode Error, latlng:' + latlng.toString());
            }
            if (latlng.x && latlng.y) {
                return alert('ReverseGeocode Error, x:' + latlng.x + ', y:' + latlng.y);
            }
            return alert('ReverseGeocode Error, Please check latlng');
        }

        var address = response.v2.address,
            htmlAddresses = [];
        addressStorge = address;
        if (address.jibunAddress !== '') {
            htmlAddresses.push('[지번 주소] ' + address.jibunAddress);
        }

        if (address.roadAddress !== '') {
            htmlAddresses.push('[도로명 주소] ' + address.roadAddress);
        }

        if (document.querySelector("div#location").firstChild) {
            document.querySelector("div#location").removeChild(document.querySelector("div#location").firstChild);
        }
        let input_address = document.createElement("input");
        input_address.setAttribute("name", "lLocation");
        input_address.setAttribute("class", "lLocation");
        input_address.setAttribute("value", address.jibunAddress);
        var resize = address.jibunAddress.length;
        console.log(resize);
        input_address.setAttribute("size", resize + 10);
        document.querySelector("div#location").appendChild(input_address);


        infoWindow.setContent([
            '<div style="padding:10px;min-width:200px;line-height:150%;">',
            '<h4 style="margin-top:5px;">현재 위치기반 주소</h4><br />',
            htmlAddresses.join('<br />'),
            '</div>'
        ].join('\n'));

        infoWindow.open(map, latlng);

    });
}

function searchAddressToCoordinate(address) {
    console.log("add", address);
    naver.maps.Service.geocode({
        query: address
    }, function (status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            if (!address) {
                return alert('Geocode Error, Please check address');
            }
            return alert('Geocode Error, address:' + address);
        }

        if (response.v2.meta.totalCount === 0) {
            return alert('No result.');
        }

        var htmlAddresses = [],
            item = response.v2.addresses[0],
            point = new naver.maps.Point(item.x, item.y);

        if (item.roadAddress) {
            htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
        }

        if (item.jibunAddress) {
            htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
        }

        if (item.englishAddress) {
            htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
        }

        if (document.querySelector("div#location").firstChild) {
            document.querySelector("div#location").removeChild(document.querySelector("div#location").firstChild);
        }

        let input_address = document.createElement("input");
        input_address.setAttribute("name", "lLocation");
        input_address.setAttribute("class", "lLocation");
        input_address.setAttribute("value", item.jibunAddress);
        document.querySelector("div#location").appendChild(input_address);


        infoWindow.setContent([
            '<div style="padding:10px;min-width:200px;line-height:150%;">',
            '<h4 style="margin-top:5px;">검색 주소 : ' + address + '</h4><br />',
            htmlAddresses.join('<br />'),
            '</div>'
        ].join('\n'));

        map.setCenter(point);
        infoWindow.open(map, point);
    });
}


//geocoder init
function initGeocoder() {
    map.addListener('click', function (e) {
        searchCoordinateToAddress(e.coord);
    });

    $('#address').on('keydown', function (e) {
        var keyCode = e.which;

        if (keyCode === 13) { // Enter Key
            searchAddressToCoordinate($('#address').val());
        }
    });

    $('#addsubmit').on('click', function (e) {
        e.preventDefault();

        searchAddressToCoordinate($('#address').val());
    });
}

naver.maps.onJSContentLoaded = initGeocoder;

