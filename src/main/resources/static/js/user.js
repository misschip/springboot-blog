
let index = {
		
		init: function() {
			let _this = this;
			console.log(this);		// this : index 객체
			// 리스너
			$("#btn-save").on("click", () => {
				
				// console.log(this);	// this : button 객체
				// 콜백 스택
				this.save();	// 위 함수를 Arrow Function으로 바꿈으로써 this가 index 객체 가리키도록 됨
				// _this.save();	// 위에서 저장해 두었던 index 객체에 대한 참조값을 사용함
			});
			
			
			$("#btn-login").on("click", () => {

				this.login();
				
			});
			
			
			$("#btn-update").on("click", () => {

				this.update();	// 위 함수를 Arrow Function으로 바꿈으로써 this가 index 객체 가리키도록 됨
			});
			
		},

		save: function() {
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
			
			$.ajax({
				type: "POST",
				url: "/auth/joinProc",		// auth 붙인 주소는 권한과 인증이 필요없는 경우인 걸로 약속
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"		// dataType: "text"로 설정하고 받은 데이터를 JSON.parse(resp) 해주면, 처음부터 "json"으로 설정하고 받은 것과 동일한 듯
				// data, contentType, dataType은 그냥 공식처럼 항상 이렇게 하면 된다!
			}).done(function(resp){
				if (resp.statusCode == 1) {
					alert("회원가입 성공");
					location.href="/";
				}			// 데이터베이스 연결 실패 등 -1, 0인 경우 처리
				console.log(resp);
				// console.log(JSON.parse(resp));
			}).fail(function(error){	// ajax 통신 실패에 대한 처리
				alert("회원가입 실패");		// db 구문 에러시에도 이쪽으로 오게 됨
				console.log(error);
			});
			
		},
		
		
		
		login: function() {
			let data = {
					username: $("#username").val(),
					password: $("#password").val()

			};
			
			$.ajax({
				type: "POST",
				url: "/auth/loginProc",		// auth 붙인 주소는 권한과 인증이 필요없는 경우인 걸로 약속
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"		// dataType: "text"로 설정하고 받은 데이터를 JSON.parse(resp) 해주면, 처음부터 "json"으로 설정하고 받은 것과 동일한 듯
				// data, contentType, dataType은 그냥 공식처럼 항상 이렇게 하면 된다!
			}).done(function(resp){	// resp는 UserController가 반환한 CommonRespDto<String> 객체임. 그래서 statusCode는 1, -1 둘 중 하나의 값을 가짐
				if (resp.statusCode == 1) {
					alert("로그인 성공");
					location.href="/";
				} else {	// -1인 경우
					alert("로그인 실패. 아이디와 패스워드를 다시 입력하시오");
				}
					
				console.log(resp);
				// location.href = "/";
				// console.log(JSON.parse(resp));
			}).fail(function(error){	// ajax 통신 실패에 대한 처리
				alert("로그인 실패");		// db 구문 에러시에도 이쪽으로 오게 됨
				console.log(error);
			});
			
		},
		
		
		
		
		update: function() {
			alert("btn-update 로직 실행");
		}
}

index.init();


/*
1. Javascript Object => JSON String
	JSON.stringify(Javascript 오브젝트);
	
2. JSON String => Javascript Object
	JSON.parse(JSON 문자열);
*/