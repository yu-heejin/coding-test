function solution(seoul) {
    let i = 0;
    
    for (const name of seoul) {
        if (name === 'Kim') {
            return `김서방은 ${i}에 있다`;
        }
        
        i++;
    }
}