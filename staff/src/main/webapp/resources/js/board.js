//계속 사용할 staffNo
let staffNo;
//페이지 다시 사용하기 위해


/** 전체검색 Ajax */	
	$("#allsearch").click(() => {
		$.ajax({
			url: "stafflist.do",
			success: list => makeStaffList(list)
		});
	});
		
	
//테이블 그리기
	
	function makeStaffList(list) {
		let pagination = list.pagination;
		console.log("페이지다",pagination);
		let staffList = list.stafflist;
		$tbl = $("<table></table>");
		$tbl.append(`
					<colgroup>
                        <col style="width:6%;">
                        <col style="width:6%;">
                        <col style="width:11%;">
                        <col style="width:12%;">
                        <col style="width:15%;">
                        <col style="width:15%;">
                           
                    </colgroup>
                    <tr id="borderhidden">
						<td colspan="6"> <a onclick="updateform();">수정</a> / <a onclick="deleteStaff();">삭제</a> </td>
                    </tr>
                    <tr>
						<th scope="col"></th>
                        <th scope="col">직원번호</th>
                        <th scope="col">이름</th>
                        <th scope="col">직급</th>
                        <th scope="col">이메일주소</th>
                        <th scope="col">전화번호</th>
                    </tr>
                    
                   	
                    
                    `);
		$("#searchCnt>a").html(`${staffList.length}건`);
		

		
		$.each(staffList, (i, c) => {
			if(c === null) {
				$tbl.append(
						`
						<tr>
						<td colspan="6"> 정보가 없습니다 </td>
						</tr>
						`);
			}
			else {
				if(c.staffNo > 0 && c.staffNo < 10){
					c.staffNo = '00'+c.staffNo
				} else if (c.staffNo >= 10 && c.staffNo < 100) {
					c.staffNo = '0'+c.staffNo
				}	
				$tbl.append(
						`
						<tr> 
						<td><input type="checkbox" value=${c.staffNo}/></td>
						<td>${c.staffNo}</td>
						<td>${c.staffName}</td> 
						<td>${c.staffRank}</td> 
						<td>${c.staffEmail}</td>
						<td>${c.staffPh}</td>
						</tr>
						`
				);
			}
				
		});
		$("#result").html($tbl);
		
		//페이징
		let pageEle = "";
		
		$("#paginationBox").html("");
		pageEle += `<ul class="pagination">`;
		if (pagination.prev === 'true') {
			pageEle += `
			<li class="page-item">
				<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')"> Previous</a>
			</li>
			`
		}
		for (let idx = `${pagination.startPage}`; idx <= `${pagination.endPage}`; idx++) {
			if (`${pagination.page}` == idx) {
				pageEle += `
				<li class="page-item active">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')" data-page="${idx}"> ${idx} </a>
				</li>
				`;
			} else {
				pageEle += `
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a>
				</li>
				`;
			}
		}
		if (`${pagination.next}`  === 'true') {
			pageEle += `
				<li class="page-item">
				<a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
				</li>
			`;
		}
		pageEle += `
			</ul>
		`;
		$("#paginationBox").append(pageEle);
		
		
		
		
		
		
	    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
	    $('input[type="checkbox"]').click(function(){
	        //클릭 이벤트 발생한 요소가 체크 상태인 경우
	        if ($(this).prop('checked')) {
	            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
	            $('input[type="checkbox"]').prop('checked', false);
	            $(this).prop('checked', true);
	        }
	    });
	}

//수정폼으로 보내기
	function updateform(){
		let sn = $('input[type="checkbox"]').val();
		staffNo = parseInt(sn);
		location.href='/staff/front/staffupdateForm.do?staffNo='+staffNo;
	}

	
//삭제하기
	function deleteStaff(){
		 if (confirm("선택한 사원을 삭제하시겠습니까?")) {
             // 확인 버튼 클릭 시 동작
             let dsn = $('input[type="checkbox"]').val();
     		staffNo = parseInt(dsn);
     		$.ajax({
     			url: "deletestaff.do",
     			type: "POST",
     			data: {staffNo},
     			success: list => makeStaffList(list)
     		});
     		alert("삭제가 완료되었습니다.");
         } else {
             // 취소 버튼 클릭 시 동작
            return;
         }
		
	}
	
//검색
	$("#search").click(() => {
		let staffRank = $("select[name=staffRank]").val(); 
		let staffPh = $("input[name=staffPh]").val();
		let staffEmail = $("input[name=staffEmail]").val();
		let staffNo = $("input[name=staffNo]").val()*1;
		let staffName = $("input[name=staffName]").val();
		console.log(typeof(staffNo));
		$.ajax({
			url: "staffsearch.do",
			type: "POST",
			data: {
				staffRank,
				staffEmail, 
				staffPh,
				staffNo,
				staffName
			},
			success: list => makeStaffList(list)
		});
		
	})

