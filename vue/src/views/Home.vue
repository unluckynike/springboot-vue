<template>
  <div>
    <el-row>
      <el-col span="12"><!-- 左右布局 总共24 一个12 -->
        <div id="main" style="width: 500px; height: 400px"></div>
      </el-col>

      <el-col span="12">
        <div id="pie" style="width: 500px; height: 400px"></div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: "Home",
  data() {
    return {}
  },
  mounted() {//页面元素渲染之后再触发

    var option = {
      title: {
        text: '各季度会员数量统计',
        subtext: '趋势图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ["第一季度", "第二季度", "第三季度", "第四季度"]
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'line'//折线图
        },
        {
          data: [],
          type: 'bar'//柱状图
        }
      ]
    };
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);

    // this.request.get("/echarts/example").then(res=>{
    //   // option.xAxis.data=res.data.x//x轴
    //   // option.series[0].data=res.data.y //折线图
    //   // option.series[1].data=res.data.y //柱状图
    //   // //准备完数据再set
    //   myChart.setOption(option);
    // })

    this.request.get("/echarts/members").then(res => {
      option.series[0].data = res.data
      option.series[1].data = res.data
      myChart.setOption(option)
    })

    //饼图
    var pitoption = {
      title: {
        text: '各季度会员数量统计',
        subtext: '比例图',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          name: 'Access From',
          type: 'pie',
          radius: '50%',
          label: {            //饼图图形上的文本标签
            normal: {
              show: true,
              position: 'inner', //标签的位置
              textStyle: {
                fontWeight: 300,
                fontSize: 14,    //文字的字体大小
                color: "#fff"
              },
              formatter: '{d}%'
            }
          },
          data: [],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };
    var pieDom = document.getElementById('pie');
    var pieChat = echarts.init(pieDom);

    this.request.get("/echarts/members").then(res => {
      pitoption.series[0].data = [
        {name: "第一季度", value: res.data[0]},
        {name: "第二季度", value: res.data[1]},
        {name: "第三季度", value: res.data[2]},
        {name: "第四季度", value: res.data[3]},
      ]
      pieChat.setOption(pitoption);
    })
  }
}
</script>

<style scoped>

</style>