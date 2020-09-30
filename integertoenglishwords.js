//Objective is to convert an integer into english words

let num = 12345


//O(n) solution that uses a hashmap to keep track of all value -> word pairs

let translations = new Map([
    [1000000000, 'Billion'],
    [1000000, 'Million'],
    [1000, 'Thousand'],
    [100, 'Hundred'],
    [90, 'Ninety'],
    [80, 'Eighty'],
    [70, 'Seventy'],
    [60, 'Sixty'],
    [50, 'Fifty'],
    [40, 'Forty'],
    [30, 'Thirty'],
    [20, 'Twenty'],
    [19, 'Nineteen'],
    [18, 'Eighteen'],
    [17, 'Seventeen'],
    [16, 'Sixteen'],
    [15, 'Fifteen'],
    [14, 'Fourteen'],
    [13, 'Thirteen'],
    [12, 'Twelve'],
    [11, 'Eleven'],
    [10, 'Ten'],
    [9, 'Nine'],
    [8, 'Eight'],
    [7, 'Seven'],
    [6, 'Six'],
    [5, 'Five'],
    [4, 'Four'],
    [3, 'Three'],
    [2, 'Two'],
    [1, 'One'],
])

if (num == 0) {
    return 'Zero'
}

if (num <= 20) {
    return translations.get(num)
}

let result = []

for (let [value, translation] of translations) {
    let repeats = Math.floor(num / value)
    
    //Too large, find smaller value
    if (repeats == 0) {
        continue
    }
    
    //Subtract the amount from the number
    num -= repeats * value
    
    //'One' Hundred, 'One' Thousand and so on...
    //Make sure not to call the next if statement
    if (repeats == 1 && value >= 100) {
        result.push('One', translation)
        continue
    }
    
    //The value is less than 100 and only repeats once
    if (repeats == 1) {
        result.push(translation)
        continue
    }
    
    //Make a recursive call to the 'repeats' to get the translation for it
    result.push(numberToWords(repeats), translation)
}

return result.join(' ')