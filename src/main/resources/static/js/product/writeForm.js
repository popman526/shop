$(document).ready(
		function() {
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
				traverseFiles(this.files);
			});

		});
