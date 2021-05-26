<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Carbon - Admin Template</title>
<link rel="stylesheet" href="css/styles.css">
<script src="js/jquery/jquery.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/chart/chart.min.js"></script>
<script src="js/chart/demo.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header bg-light">Bar Charts</div>

						<div class="card-body">
							<canvas id="bar-chart" width="100%" height="50"></canvas>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card">
						<div class="card-header bg-light">Line Charts</div>

						<div class="card-body">
							<canvas id="line-chart" width="100%" height="50"></canvas>
						</div>
					</div>
				</div>
			</div>

			<div class="row mt-4">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header bg-light">Radar Chart</div>

						<div class="card-body">
							<canvas id="radar-chart" width="100%" height="50"></canvas>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card">
						<div class="card-header bg-light">Pie Chart</div>

						<div class="card-body">
							<canvas id="pie-chart" width="100%" height="50"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
