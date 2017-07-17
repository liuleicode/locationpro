<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <style>
        body {
            font-family: "Microsoft YaHei";
            font-size: 0.7rem;
            line-height: 0.7rem;
            width: 100%;
            background: #f2f2f2;
        }
        .h1{
            align-content: center;
            font-size:16px;
            background-color: #fff;
        }
        .div h2{
            background-color: #fff;
            font-size:14px;
            margin-top:2px;
        }
        .div span {
            font-size:12px;
            background-color: #fff;
            margin-bottom:1px;
        }
        .box{
            border-top: 2px solid #43ccb5;
            margin-top:5px;
            margin-bottom:10px;
            background-color: #fff;
        }
        .contaniner {
            width: 100%;
            overflow: hidden;
        }
       
    </style>
</head>
<body>
<div>
    <div>
    <h1> <span th:text="${localdtl.name}"></span></h1>
    <div style="margin-right: 2%;">
        <img  src="/images/gwm/gwmcc.jpg" width="90%" />
    </div>
    </div>

    <div class="contaniner fixed-cont">

    <div class="box">
        <h2>地名的来历 </h2>
        <span th:text="${localdtl.mainhistoryevolution}">
        </span>
    </div>

    <div class="box">
        <h2>地名的含义 </h2>
        <span th:text="${localdtl.mainmeanofname}"></span>
    </div>


    <div class="box">
        <h2>地名的历史沿革 </h2>
        <span th:text="${localdtl.mainhistoryevolution}"></span>
    </div>

    <div class="box">
        <h2>地理实体概况 </h2>
        <span th:text="${localdtl.mainlocalinfo}"></span>
            <!-- <ul>
            <li>【位置信息】位于山阴县张家庄乡旧广武村附近。</li>
             <li>【遗址详简】修筑长城一般都就地取材，城砖和石灰石就地烧制，高山峻岭地段开采石料，用石头堆砌。</li>
             <li>【长宽、结构信息】在沙漠地段用红柳枝条和芦苇与砂石一层层铺砌。黄土地区，大都采取土垒筑。在重要地段的城墙一般用砖和石头砌。城墙高低宽窄不一，平均高在7米，墙基一般宽在6米，顶宽5米。</li>
             <li>【其它信息】2001年，广武明长城被国务院批准列入第五批全国重点文物保护单位。</li>
            </ul>-->

    </div>

    <div class="box">
        <h2>资料来源</h2>
        <span :text="${localdtl.infosource}"></span>
    </div>
    </div>
</div>
</body>
</html>