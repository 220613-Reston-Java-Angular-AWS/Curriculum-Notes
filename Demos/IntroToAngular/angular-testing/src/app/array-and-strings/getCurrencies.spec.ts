import { getCurrencies } from "./getCurrencies";

describe('getCurrencies', () => {
    //note we dont care about the order
    //why? because the order can change

    const result = getCurrencies();

    it('should include the specified currency', () => {
    expect(result).toContain('USD')
    expect(result).toContain('AUD')
    // expect(result).toContain('EUR')

})

})