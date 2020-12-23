<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!--  通过此处可以调整图的大小 -->
<div id="container" style="height: 40%; width: 30%; margin-left:300px;">

</div>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts@4/dist/echarts.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts-gl@1/dist/echarts-gl.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts-stat@1/dist/ecStat.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/dataTool.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/china.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/world.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/bmap.min.js"></script>
	
<script type="text/javascript">
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	option = null;
	// 随机生成日期
	function randomData() {
		now = new Date(+now + oneDay);
		value = value + Math.random() * 21 - 10;
		return {
			name : now.toString(),
			value : [[ now.getFullYear(), now.getMonth() + 1, now.getDate() ]
							.join('/'), Math.round(value) ]
		};
	}

	var data = [];
	var now = +new Date(2018, 1, 1); // 控制横坐标的时间
	var oneDay = 24 * 3600 * 1000;
	var value = Math.random() * 1000;
	for (var i = 0; i < 1000; i++) {
		data.push(randomData());
	}

	option = {
// 		title : {
// 			text : '基金历史走势图'
// 		},
		tooltip : {
			trigger : 'axis',
			formatter : function(params) {
				params = params[0];
				var date = new Date(params.name);
				return date.getDate() + '/' + (date.getMonth() + 1) + '/'
						+ date.getFullYear() + ' : ' + params.value[1];
			},
			axisPointer : {
				animation : false
			}
		},
		xAxis : {
			type : 'time', // 不能修改
			splitLine : {
				show : false // 是否要显示时间分割线
			}
		},
		yAxis : {
			type : 'value', // 不能修改
			boundaryGap : [ 0, '100%' ],
			splitLine : {
				show : false // 是否要显示纵坐标值的分割线
			}
		},
		series : [ {
			name : '模拟数据',
			type : 'line',
			showSymbol : false,
			hoverAnimation : true,
			data : data
		} ]
	};

	setInterval(function() {

		for (var i = 0; i < 2; i++) { // 控制显示的时间间隔
			data.shift();
			data.push(randomData());
		}

		myChart.setOption({
			series : [ {
				data : data
			} ]
		});
	}, 1000);
	;
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
</script>