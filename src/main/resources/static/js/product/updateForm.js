$(document).ready(function() {
	var productState = document.getElementById("productState").value;
	var stateField = document.getElementById("state");
	stateField.options[productState - 1].selected = true;
 
	function traverseFiles(files) {
		var fileInfo;
		$(".file-list").html("");
		for (var i = 0; i < files.length; i++) {
			var reader = new FileReader();
			reader.readAsDataURL(files[i]);
			reader.onload = function(e) {
				fileInfo = "<img src='" + e.target.result
						+ "' width='455px' height='400px'/>";
				$(".file-list").append(fileInfo);
			};
			$(".file-list").append(fileInfo);
		}
	}
	$("#files-upload").change(function() {
		deleteLegacyImages();
		traverseFiles(this.files);
	});

});

function deleteLegacyImages() {
	document.getElementById("deletelegacy").value = "DELETE_LEGACY_FILES";
	document.getElementById("legacyFileDiv").style = "display:none;";
}
