
import { greet } from "./greet";

describe('greet', () => {

    it('should include the name in the input', () =>{

        // expect(greet('Tiffany')).toBe('Welcome Tiffany');
        // note that we do not want to write fragile tests that break easily
        // we want to make more general tests so they are not tooo specific

        expect(greet('Tiffany')).toContain("Tiffany");

        //Todo:
        //how can we make it work for uppercase and lowercase letters?
    })

})