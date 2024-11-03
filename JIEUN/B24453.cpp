#include <string>
#include <stdio.h>
#include <math.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <queue>
#include <stack>
#include <climits>
#include <set>

#define SWAP(a, b, type) do { \
    type temp; \
    temp = a;  \
    a = b;     \
    b = temp;  \
} while (0)

#define INF 1000000000
#define endl '\n'
#define ll long long

using namespace std;

bool error[20000001];
int N,M;
int X,Y;

void input() {
    cin>>N>>M;
    int x;
    for(int i=0;i<M;i++){
        cin>>x;
        error[x]=true;
    }
    cin>>X>>Y;
}

void init() {
}


void solution() {
    int start=1,end=1;
    int er_cnt=0; // er_cnt는 start~end까지 에러의 개수
    int su_cnt=0; // su_cnt는 start~end까지 연속된 줄의 개수
    int ans=INT_MAX; // ans는 인규가 지워야하는 최소 에러 개수가 된다.
    
    if(N==1){
        cout<<M-Y; // N은 1일 때, (에러의 개수-인규가 찾아야하는 에러개수) 출력
        return;
    }
    
    while(1){
        if(start==N) break;
        if((er_cnt<Y||su_cnt<X)&&end<=N){ //모든 조건을 만족하지 않은 경우 end를 움직인다.
            if(error[end++]) er_cnt++; //현재 줄에 에러가 있다면 에러 개수를 늘려준다.
            su_cnt++;
        }else{
            if(er_cnt>=Y&&su_cnt>=X) ans=min(ans,er_cnt); //모든 조건을 만족한다면 ans를 갱신해준다.
            if(error[start++]) er_cnt--; //현재 줄에 에러가 있다면 에러 개수를 줄여준다.
            su_cnt--;
        }
    }
    
    //전체 에러의 개수 - 최소로 인규가 지워야하는 에러의 개수가 답이 된다.
    cout<<M-ans;
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    input();
    solution();
    return 0;
}
