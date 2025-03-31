通过委托实现recyclerview多布局
Delegate 模式的优势
优势
1.高内聚	每种 Item 类型的所有逻辑集中在一个类中
2.低耦合	新增 Item 类型只需添加新的 Delegate，无需修改现有代码
3.易复用	Delegate 可以在不同 Adapter 中重复使用
4.易测试	每个 Delegate 可以独立进行单元测试
5.可扩展	轻松支持动态添加/移除 Item 类型
