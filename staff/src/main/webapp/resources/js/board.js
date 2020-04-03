
/** 전체검색 Ajax */	
	$("#allsearch").click(() => {
		$.ajax({
			url: "stafflist.do",
			success: list => makeStaffList(list)
		});
	});
		
	
//테이블 그리기
	
	function makeStaffList(list) {
		
		$tbl = $("<table></table>");
		$tbl.append(`<colgroup>
                        <col style="width:6%;">
                        <col style="width:15%;">
                        <col style="width:11%;">
                        <col style="width:15%;">
                        <col style="width:12%;">
                        <col style="width:15%;">
                           
                    </colgroup>

                    <tr>
                        <th scope="col">직원번호</th>
                        <th scope="col">이름</th>
                        <th scope="col">직급</th>
                        <th scope="col">이메일주소</th>
                        <th scope="col">전화번호</th>
                        <th scope="col"></th>
                    </tr>
                    
                    `);
		$("#searchCnt>a").html(`${list.length}건`);

		$.each(list, (i, c) => {
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
						<td>${c.staffNo}</td>
						<td>${c.staffName}</td> 
						<td>${c.staffRank}</td> 
						<td>${c.staffEmail}</td>
						<td>${c.staffPh}</td>
						<td><button type="button" onclick="updateform(${c.staffNo});">수정</button> / <button type="button" onclick="deleteStaff(${c.staffNo});">삭제</button></td>
						</tr>
						`
				);
			}
				
		});
		$("#result").html($tbl);
	}

//수정폼으로 보내기
	function updateform(staffNo){
		location.href='/kr.co.staff/front/staffupdateForm.do?staffNo='+staffNo;
	}

	
//삭제하기
	function deleteStaff(staffNo){
		$.ajax({
			url: "deletestaff.do",
			type: "POST",
			data: {staffNo},
			success: list => makeStaffList(list)
		});
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

