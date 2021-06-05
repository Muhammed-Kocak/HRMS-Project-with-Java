package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.utilities.results.Result;

public class BusinessRules {
	 public static Result Run(Result... logics)
    {
        for (Result result : logics)
        {
            if (!result.isSuccess())
            {
                return result;
            }
        }

        return null;
    }
}
