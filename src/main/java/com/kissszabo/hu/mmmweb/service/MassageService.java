package com.kissszabo.hu.mmmweb.service;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import java.util.List;

public interface MassageService {
    List<MassageUITO> getAllMassages();
    MassageUITO getMassage(MassageUITO massageUITO);
    MassageUITO saveMassage(MassageUITO massageUITO);
    void deleteMassage(MassageUITO massageUiTO);
}
