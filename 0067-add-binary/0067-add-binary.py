class Solution:
    def addBinary(self, a: str, b: str) -> str:
        response = ""
        carry = 0
        # 1의 자리부터 더하기 위해 문자열 역순 정렬
        a, b = a[::-1], b[::-1]

        for i in range(max(len(a), len(b))):
            # 길이가 긴 쪽을 기준으로 for loop
            # => a, b 의 각 자리 digit 추출. 길이가 짧은 쪽은 default value == 0, using ASCII
            digit_a = ord(a[i]) - ord("0") if i < len(a) else 0
            digit_b = ord(b[i]) - ord("0") if i < len(b) else 0

            total = digit_a + digit_b + carry  # 1 + 1 + 0
            # binary -> mod by 2
            char = str(total % 2)
            response = char + response
            # binary -> divide by 2
            carry = total // 2  # 다음 자릿수로 carry 되는 수가 있다면

        # for loop 종료 후 다음 자릿수로 carry 되는 수가 있다면
        if carry:
            response = "1" + response

        return response