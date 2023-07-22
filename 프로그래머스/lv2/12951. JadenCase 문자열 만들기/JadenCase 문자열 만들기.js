function solution(s) {
    const words = s.split(" ");
    const answer = [];
    
    for (const w of words) {
        let temp = w.toLowerCase();
        let first = temp.charAt(0);
        
        if (first === temp.charAt(0).toLowerCase()) {
            first = first.toUpperCase();
        }
        
        answer.push(`${first}${temp.substr(1)}`);
    }
    
    return answer.join(" ");
}