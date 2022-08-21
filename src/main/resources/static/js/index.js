$(window).on('load', function () {
	load('.child-page-listing', '4');
	$("#js-btn-wrap .button").on("click", function () {
		load('.child-page-listing', '4', '#js-btn-wrap');
	})
});

function load(id, cnt, btn) {
	var contents_list = id + " .lostBoardListContainer:not(.active)";
	var contents_length = $(contents_list).length;
	var contents_total_cnt;
	if (cnt < contents_length) {
		contents_total_cnt = cnt;
	} else {
		contents_total_cnt = contents_length;
		$('.button').hide()
	}
	$(contents_list + ":lt(" + contents_total_cnt + ")").addClass("active");
}

