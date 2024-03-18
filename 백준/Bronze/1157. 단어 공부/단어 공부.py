# 대문자 출력이므로 대문자로
word = input().upper()

# 첫 문자의 개수를 임의의 최댓값으로 지정
maxCnt = word.count(word[0])
max = word[0]
# 중복 검사 방지 (memoization?)
checked = [word[0]]
# 최댓값이 여러 개일 때: 최댓값 저장, 최댓값이 여러 개가 아닐 때: 0
q = 0

# count 메서드를 매번 호출하는 것보다 이게 나은지 아직 몰르겄음
for i in word:
    if i in checked:
        pass
    else:
        cnt = word.count(i)
        if (cnt == maxCnt):
            q = cnt
        if (cnt > maxCnt):
            maxCnt = cnt
            max = i
        checked.append(i)

# 최댓값이 여러 개일 때
if (maxCnt == q):
    max = '?'

print(max)