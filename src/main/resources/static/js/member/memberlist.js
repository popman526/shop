$(function() {
	fnGetMembers();
});

function fnGetMembers() {
	$.ajax({
		url : "/members",
		method : "GET",
		success : function(response) {
			
			var html = "";
			response.forEach(function(member) {
				html += "<tr>";
				html += "<td>" + member.id + "</td>";
				html += "<td>" + member.memberId + "</td>";
				html += "<td>" + member.name + "</td>";
				html += "<td>" + member.role + "</td>";
				html += "</tr>";
			});
			
			$("#members").html(html);
			
		},
		error : function(e) {
			console.log(e);
		}
	});
}