$(document).ready(function () {      
	var dynamicColors = function (opacity) {
		var r = Math.floor(Math.random() * 255);
		var g = Math.floor(Math.random() * 255);
		var b = Math.floor(Math.random() * 255);
		var a = opacity;
		return "rgba(" + r + "," + g + "," + b + "," + a + ")";
	}	
	var getColorArr = function (length, opacity) {
		var colorArr = new Array();
		for (var i = 0; i < length; i++) {
			colorArr.push(dynamicColors(opacity));
		}
		return colorArr;
	}

	/**
	 * Bar Chart
	 */   
	var barChart = $('#bar-chart');    
	var barLabel = eval('(' + carNumNameBar + ')');
	var barData = eval('(' + carNumValueBar + ')');	
	var chartData = {
			labels: barLabel,
			datasets: [{
				data: barData,          
				label: '总车辆数量',
				backgroundColor: getColorArr(barLabel.length,0.5),
				borderWidth: 1
			}]
	};
	if (barChart.length > 0) {
		new Chart(barChart, {
			type: 'bar',
			data: chartData,
			options: {
				hover: {
					animationDuration: 0
				}, 
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero:true,
							stepSize: 1
						}
					}]
				},
				animation: {
					onComplete: function () {
						var chartInstance = this.chart,
						ctx = chartInstance.ctx;
						ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
						ctx.textAlign = 'center';
						this.data.datasets.forEach(function (dataset, i) {
							var meta = chartInstance.controller.getDatasetMeta(i);
							meta.data.forEach(function (bar, index) {
								var data = dataset.data[index];
								ctx.fillText(data, bar._model.x, bar._model.y - 5);
							});
						});
					}
				}
			}
		});
	}

	/**
	 * Line Chart
	 */
	var lineChart = $('#line-chart');  
	var lineLabel = eval('(' + carNumNameLine + ')');
	var lineB1CarsNumData = eval('(' + B1CarsNumValueLine + ')');
	var lineB2CarsNumData = eval('(' + B2CarsNumValueLine + ')');
	var lineC1CarsNumData = eval('(' + C1CarsNumValueLine + ')');
	var lineC2CarsNumData = eval('(' + C2CarsNumValueLine + ')');
	var chartData = {
			labels: lineLabel,
			datasets: [{
				data: lineB1CarsNumData,          
				label: 'B1数量',
				backgroundColor: getColorArr(lineLabel.length,0.5),
				borderWidth: 1
			},
			{
				data: lineB2CarsNumData,          
				label: 'B2数量',
				backgroundColor: getColorArr(lineLabel.length,0.5),
				borderWidth: 1
			},
			{
				data: lineC1CarsNumData,          
				label: 'C1数量',
				backgroundColor: getColorArr(lineLabel.length,0.5),
				borderWidth: 1
			},
			{
				data: lineC2CarsNumData,          
				label: 'C2数量',
				backgroundColor: getColorArr(lineLabel.length,0.5),
				borderWidth: 1
			}]
	};
	if (lineChart.length > 0) {
		new Chart(lineChart, {
			type: 'line',
			data: chartData,
			options: {
				hover: {
					animationDuration: 0
				}, 
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero:true,
							stepSize: 1
						}
					}]
				},
				animation: {
					onComplete: function () {
						var chartInstance = this.chart,
						ctx = chartInstance.ctx;
						ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
						ctx.textAlign = 'center';
						this.data.datasets.forEach(function (dataset, i) {
							var meta = chartInstance.controller.getDatasetMeta(i);
							meta.data.forEach(function (bar, index) {
								var data = dataset.data[index];
								ctx.fillText(data, bar._model.x, bar._model.y - 5);
							});
						});
					}
				}
			}
		});
	}
});
