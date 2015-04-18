#include<iostream>
using namespace std;
class Top{};
class Middle :public Top{};
class Bottom :public Middle{};

template<typename T>
class SmartPtr{
public:
	SmartPtr(T* ptr):heldPtr(ptr){
	}
	//如果你想控制copy构造的方方面面，你必须同时声明泛化copy构造函数和"正常的"copy构造函数。
	//相同规则也适用于赋值操作
	SmartPtr(const SmartPtr& other){

	}
	template<typename U>
	SmartPtr(const SmartPtr<U>& other):heldPtr(other.get()){
	};
	T* get(){
		return heldPtr; 
	}
private:
	T* heldPtr;
};
int main(){
	//Top* pt1 = new Middle();
	//Top* pt2 = new Bottom();
	//const Top*pct2 = pt1;

	//让智能指针具有和普通指针类似的行为
	SmartPtr<Top> pt1 = SmartPtr<Middle>(new Middle());
	SmartPtr<Top> pt2 = SmartPtr<Bottom>(new Bottom());
	SmartPtr<const Top> pct2 = pt1;
}